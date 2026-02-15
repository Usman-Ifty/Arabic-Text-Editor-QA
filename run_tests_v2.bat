@echo off
setlocal

echo ==========================================
echo      ARABIC TEXT EDITOR QA - TEST RUNNER (FIXED)
echo ==========================================

REM --- 1. FIND JAVA ---
set "JAVA_HOME=C:\Program Files\Java\jdk-21"
if not exist "%JAVA_HOME%" (
    REM Try to find it dynamically if specific version folder is wrong
    for /d %%i in ("C:\Program Files\Java\jdk-21*") do set "JAVA_HOME=%%i"
)

if not exist "%JAVA_HOME%" (
    echo [ERROR] Could not find Java in C:\Program Files\Java.
    echo Please ensure JDK 21 is installed.
    pause
    exit /b 1
)

set "PATH=%JAVA_HOME%\bin;%PATH%"
echo [OK] Java found at: %JAVA_HOME%
java -version

REM --- 2. SET UP MAVEN ---
if exist "apache-maven-3.9.6" (
    echo [OK] Maven folder exists.
) else (
    echo [INFO] Downloading Maven...
    REM Use a more reliable mirror or direct Archive link
    curl -L -o maven.zip "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
    
    echo [INFO] Extracting Maven...
    tar -xf maven.zip
    
    del maven.zip
)

set "M2_HOME=%CD%\apache-maven-3.9.6"
set "PATH=%M2_HOME%\bin;%PATH%"

echo [OK] Maven configured.
call mvn -version

REM --- 3. RUN TESTS ---
echo.
echo [INFO] Running JUnit 5 Tests...
echo.

call mvn -Dstyle.color=always test

if %errorlevel% neq 0 (
    echo.
    echo [FAIL] Some tests failed! This is EXPECTED.
    echo The assignment requires you to fix bugs.
) else (
    echo.
    echo [SUCCESS] All tests passed!
)

echo.
echo ==========================================
echo      TEST RUN COMPLETE
echo ==========================================
pause
