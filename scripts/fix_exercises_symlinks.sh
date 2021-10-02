#!/usr/bin/env bash

# This script looks through each exercise folder to identify symlinked files in the .meta folder and replaces the files
# with actual symlinks. This is mainly to fix weird behavior with Git and symlinks.

grep -R -e '^\.\./\.\.' exercises | cut -d: -f1 - | while IFS= read -r file
do
    dir=$(dirname "$file")
    filename=$(basename "$file")
    target=$(cat "$file")

    echo "Replacing ${file} with symlink to ${target}."

    pushd "$dir" || continue
    rm -f "$filename"
    ln -s "$target" "$filename"
    popd || continue

    unset dir filename
done
