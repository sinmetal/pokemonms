@echo off
:: encode is utf-8

python ../closure-library\closure\bin\build\depswriter.py ^
--root_with_prefix="scripts ../../../authentication/scripts" ^
--output_file=deps.js
pause
