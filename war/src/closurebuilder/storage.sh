#!/bin/sh
python ../../lib/closure-library/closure/bin/build/closurebuilder.py \
  --root=../../lib/closure-library \
  --root=../scripts \
  -n storage.App \
  -o compiled \
  --output_file=../files/storage/scripts.js \
  -c ../../../lib/compiler.jar \
  -f "--compilation_level=ADVANCED_OPTIMIZATIONS"