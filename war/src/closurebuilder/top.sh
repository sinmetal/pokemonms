#!/bin/sh

python ../../lib/closure-library/closure/bin/build/closurebuilder.py \
	--root=../../lib/closure-library \
	--root=../scripts \
	-n top.App \
	-o compiled \
	--output_file=../files/top/scripts.js \
	-c ../../../lib/compiler.jar \
	-f "--compilation_level=ADVANCED_OPTIMIZATIONS"
