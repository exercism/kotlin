#!/usr/bin/env bash
set -e
gradle --version

echo ""
echo ">>> Running configlet..."
bin/fetch-configlet
bin/configlet .

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb gradle check compileStarterSourceKotlin --continue
popd

