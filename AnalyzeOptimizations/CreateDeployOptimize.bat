
for %%f in (*.bar) do (
call mqsicreateworkdir %%~nf
call ibmint deploy --input-bar-file %%~nf.bar --output-work-directory ./%%~nf
call ibmint optimize server --work-directory ./%%~nf
)
call java -classpath ".\bin;C:\Program Files\IBM\ACE\12.0.5.0\common\jackson\lib\snakeyaml-1.30.jar" com.ibm.dev.AnalyzeOptimizations