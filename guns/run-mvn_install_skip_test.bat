@echo off
title %cd%
echo.
echo [��Ϣ] ʹ��mvn���빤�̡�
echo.
rem pause
rem echo.

cd %~dp0
call mvn install -Dmaven.test.skip=true


pause