xcopy /y c:\onlinejudge\a.cpp c:\onlinejudge\result
xcopy /y c:\onlinejudge\in.txt c:\onlinejudge\result
xcopy /y c:\onlinejudge\answer.txt c:\onlinejudge\result
cd /d c:\onlinejudge\result
g++ a.cpp
if not exist a.exe (
	g++ a.cpp>error.txt 2>&1
	echo 4 >result.txt
	xcopy /y c:\onlinejudge\result\result.txt c:\onlinejudge
	del /f /s /q c:\onlinejudge\result
	exit
)
set /a start_time=(1%time:~9,2%-100)*10+(1%time:~6,2%-100)*1000
start c:\onlinejudge\tmp.bat
type in.txt|a.exe >out.txt
set /a end_time=(1%time:~9,2%-100)*10+(1%time:~6,2%-100)*1000
start c:\onlinejudge\memory.bat
set /a used_time=(%end_time%-%start_time%)/50
if %errorlevel% NEQ 0 (
	if %errorlevel% EQU 1 (echo 2 >result.txt) else (echo 3 >result.txt)
	echo %used_time% > time.txt
	xcopy /y c:\onlinejudge\result\result.txt c:\onlinejudge
	xcopy /y c:\onlinejudge\result\time.txt c:\onlinejudge
	del /f /s /q c:\onlinejudge\result
	exit
)
fc answer.txt out.txt
if %errorlevel% EQU 0 (echo 0 >result.txt) else (echo 1 >result.txt)
echo %used_time% > time.txt
xcopy /y c:\onlinejudge\result\time.txt c:\onlinejudge
xcopy /y c:\onlinejudge\result\result.txt c:\onlinejudge
del /f /s /q c:\onlinejudge\result
exit

