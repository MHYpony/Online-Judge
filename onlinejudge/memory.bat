echo off
cd /d c:/onlinejudge/result
choice /t 1 /d y /n >nul
tasklist /nh|find /i "a.exe"
if errorlevel 1 (echo success) else (taskkill /f /im a.exe exit)
for /f "tokens=2 delims=," %%a in ('tasklist /fo csv^|findstr /i /c:"a.exe"') do set id=%%a
echo %id%
set var=0
for /f "skip=1 tokens=2 delims==" %%a in ('wmic process where "processid='%id%'" get workingsetsize /value') do ( 
echo %%a
set /a var=%%a/1024)
echo %var% K
echo %var% >C:\onlinejudge\memory.txt
exit