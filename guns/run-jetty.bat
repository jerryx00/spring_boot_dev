@echo ��ӭʹ��Nutz
title %cd%
echo [��Ϣ] ʹ��jetty���й��̡�

rem pause
rem echo.

cd %~dp0
call mvn jetty:run


pause