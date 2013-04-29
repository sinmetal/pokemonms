#!/bin/sh

python ../lib/closure-library/closure/bin/build/depswriter.py \
--root_with_prefix="scripts ../../../../src/scripts" \
--output_file=deps.js
