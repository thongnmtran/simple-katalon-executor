
set kre=C:\Users\thongnmtran\Desktop\KRE-8.0.1\Katalon_Studio_Engine_Windows_64-8.0.1

set command=katalonc -noSplash -runMode=console -projectPath=\\\"C:\Users\thongnmtran\Desktop\Samples\Web 03\test.prj\\\" -retry=0 -testSuitePath=\\\"Test Suites/TS_RegressionTest\\\" -executionProfile=\\\"default\\\" -browserType=\\\"Chrome\\\" -apiKey=\\\"36208c97-ecee-44ff-8373-4e3270e7e7d0\\\"


java -jar target/com.katalon.executor-0.0.1-SNAPSHOT-shaded.jar -c="%command%" -k="%kre%"