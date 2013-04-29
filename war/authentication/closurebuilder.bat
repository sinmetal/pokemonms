@echo off
:: encode is utf-8

python ../closure-library/closure/bin/build/closurebuilder.py ^
  --root=../closure-library ^
  --root=scripts ^
  -n authentication.App ^
  -o compiled ^
  --output_file=files/scripts.js ^
  -c D:\usr\bin\closure-tools\compiler-latest\bin\compiler.jar ^
  -f "--compilation_level=ADVANCED_OPTIMIZATIONS"
pause