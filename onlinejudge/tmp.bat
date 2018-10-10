echo off
cd /d c:/onlinejudge/result
choice /t 2 /d y /n >nul
tasklist /nh|find /i "a.exe"
if errorlevel 1 (echo success) else (taskkill /f /im a.exe)
exit
