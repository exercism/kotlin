#!/usr/bin/env bash

TRACK=kotlin
TRACK_REPO="$TRACK"
EXERCISES_TO_SOLVE=$@

on_exit() {
    echo ">>> on_exit()"
    cd $EXECPATH
    echo "<<< on_exit()"
}

assert_installed() {
    local binary=$1
    echo ">>> assert_installed(binary=\"${binary}\")"
    
    if [[ "`which $binary`" == "" ]]; then
        echo "${binary} not found; it is required to perform this test."
        echo -e "Have you completed the setup instructions at https://github.com/exercism/${TRACK_REPO} ?\n"
        echo "PATH=${PATH}"
        echo "aborting."
        exit 1
    fi
    echo "<<< assert_installed()"
}

clean() {
    local build_dir="$1"
    echo ">>> clean(build_dir=\"${build_dir}\")"
    
    # empty, absolute path, or parent reference are considered dangerous to rm -rf against.
    if [[ "${build_dir}" == "" || ${build_dir} =~ ^/ || ${build_dir} =~ \.\. ]] ; then
        echo "Value for build_dir looks dangerous.  Aborting."
        exit 1
    fi
    
    local build_path=$( pwd )/${build_dir}
    if [[ -d "${build_path}" ]] ; then
        echo "Cleaning journey script build output directory (${build_path})."
        rm -rf "${build_path}"
    fi
    cd exercises
    "$EXECPATH"/gradlew clean
    cd ..
    echo "<<< clean()"
}

solve_exercise() {
    local exercise="$1"
    local exercise_type="$2"

    echo -e "\n\n"
    echo "=================================================="
    echo "Solving ${exercise}"
    echo "=================================================="

    mkdir -p ${exercism_exercises_dir}/${TRACK}
    cp -R -H ${track_root}/exercises/${exercise_type}/${exercise} ${exercism_exercises_dir}/${TRACK}/${exercise}
    cp -R -H ${track_root}/exercises/${exercise_type}/${exercise}/.meta/src/reference/${TRACK}/* ${exercism_exercises_dir}/${TRACK}/${exercise}/src/main/${TRACK}/
    
    pushd ${exercism_exercises_dir}/${TRACK}/${exercise}
    # Check that tests compile before we strip @Ignore annotations
    "$EXECPATH"/gradlew compileTestJava
    # Ensure we run all the tests (as delivered, all but the first is @Ignore'd)
    for testfile in `find src/test/kotlin -name "*Test.kt"`; do
        # Strip @Ignore annotations to ensure we run the tests (as delivered, all but the first is @Ignore'd).
        # Note that unit-test.sh also strips @Ignore annotations via the Gradle task copyTestsFilteringIgnores.
        # The stripping implementations here and in copyTestsFilteringIgnores should be kept consistent.
        sed 's/@Ignore\(\(.*\)\)\{0,1\}//' ${testfile} > "${tempfile}" && mv "${tempfile}" "${testfile}"
    done
    "$EXECPATH"/gradlew test
    echo "exit code: $?"
    popd
}

solve_all_exercises() {
    local exercism_exercises_dir="$1"
    echo ">>> solve_all_exercises(exercism_exercises_dir=\"${exercism_exercises_dir}\")"
    
    local track_root=$( pwd )
    local concept_exercises=`jq -r '.exercises.concept[].slug | sort' config.json | sort | xargs`
    local practice_exercises=`jq -r '.exercises.practice[].slug' config.json | sort | xargs`
    local total_exercises=`jq '.exercises.concept + .exercises.practice | length' config.json`
    local current_exercise_number=1
    local tempfile="${TMPDIR:-/tmp}/journey-test.sh-unignore_all_tests.txt"

    mkdir -p ${exercism_exercises_dir}
    pushd ${exercism_exercises_dir}

    for exercise in $concept_exercises; do
        echo -e "\n\n"
        echo "=================================================="
        echo "${current_exercise_number} of ${total_exercises} -- ${exercise}"
        echo "=================================================="
        
        solve_exercise "${exercise}" "concept"
        
        current_exercise_number=$((current_exercise_number + 1))
    done

    for exercise in $practice_exercises; do
        echo -e "\n\n"
        echo "=================================================="
        echo "${current_exercise_number} of ${total_exercises} -- ${exercise}"
        echo "=================================================="
        
        solve_exercise "${exercise}" "practice"
        
        current_exercise_number=$((current_exercise_number + 1))
    done
    popd
}

solve_single_exercise() {
    local exercism_exercises_dir="$1"
    local exercise_to_solve="$2"
    local exercise_type="$3"
    echo ">>> solve_single_exercises(exercism_exercises_dir=\"${exercism_exercises_dir}\", exercise_to_solve=\"$exercise_to_solve\")"
    
    local track_root=$( pwd )
    local tempfile="${TMPDIR:-/tmp}/journey-test.sh-unignore_all_tests.txt"
    
    mkdir -p ${exercism_exercises_dir}
    pushd ${exercism_exercises_dir}
    
    solve_exercise "${exercise_to_solve}" "${exercise_type}"
    
    popd
}

main() {
    # all functions assume current working directory is repository root.
    cd "${SCRIPTPATH}/.."
    
    local track_root=$( pwd )
    local build_dir="build"
    local build_path="${track_root}/${build_dir}"
    
    local exercism_home="${build_path}/exercism"
    
    # fail fast if required binaries are not installed.
    assert_installed "jq"
    
    clean "${build_dir}"
    
    if [[ $EXERCISES_TO_SOLVE == "" ]]; then
        solve_all_exercises "${exercism_home}"
    else
        for exercise in $EXERCISES_TO_SOLVE; do
            if [ -d "${exercism_home}/exercises/concept/${exercise}" ]; then
                solve_single_exercise "${exercism_home}" "${exercise}" "concept"
            else
                solve_single_exercise "${exercism_home}" "${exercise}" "practice"
            fi
        done
    fi
}

##########################################################################
# Execution begins here...

# If any command fails, fail the script.
set -ex
SCRIPTPATH=$( pushd `dirname $0` > /dev/null && pwd && popd > /dev/null )
EXECPATH=$( pwd )
# Make output easier to read in CI
TERM=dumb

trap on_exit EXIT
main

