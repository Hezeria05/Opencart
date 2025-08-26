@echo off
echo Running Maven tests in Opencart project...

cd /d C:\Workspace\SeleniumWebdriver\Opencart
mvn clean test

echo.
echo ===== Execution Finished =====
pause
