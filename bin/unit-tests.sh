#!/usr/bin/env bash
set -e
./gradlew --version

# Clean up any left-over files from a previous invocation, to avoid configlet
# erroring when it finds an unexpected directory inside exercises.
rm -rf ./exercises/build

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet lint

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb ../gradlew check compileStarterSourceKotlin --continue
popd

