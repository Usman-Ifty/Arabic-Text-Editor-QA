@echo off
setlocal

echo ==========================================
echo      ARABIC TEXT EDITOR QA - TEST RUNNER
echo ==========================================

REM --- 1. SET UP MAVEN ---
if exist "apache-maven-3.9.6" (
    echo [OK] Maven is already installed.
) else (
    echo [INFO] Maven not found. Downloading...
    curl -L -o maven.zip "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
    
    echo [INFO] Extracting Maven...
    tar -xf maven.zip
    
    del maven.zip
    echo [OK] Maven installed.
)

REM --- 2. CONFIGURE MAVEN PATH ---
set "M2_HOME=%CD%\apache-maven-3.9.6"
set "PATH=%M2_HOME%\bin;%PATH%"

REM --- 3. VERIFY JAVA ---
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java is not installed or not in PATH!
    echo Please install Java 21+ and try again.
    pause
    exit /b 1
)

REM --- 4. RUN TESTS ---
echo.
echo [INFO] Running JUnit 5 Tests...
echo.

call mvn -Dstyle.color=always test

if %errorlevel% neq 0 (
    echo.
    echo [FAIL] Some tests failed! This is EXPECTED for the assignment.
    echo You need to fix the bugs in the code.
) else (
    echo.
    echo [SUCCESS] All tests passed!
)

echo.
echo ==========================================
echo      TEST RUN COMPLETE
echo ==========================================
pause
