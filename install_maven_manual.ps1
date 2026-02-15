$Url = "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
$ZipFile = "maven.zip"
$Dest = "."

Write-Host "Downloading Maven from $Url..."
Invoke-WebRequest -Uri $Url -OutFile $ZipFile

Write-Host "Extracting Maven..."
Expand-Archive -Path $ZipFile -DestinationPath $Dest -Force

Write-Host "Maven installed to $(Get-Location)\apache-maven-3.9.6"
Remove-Item $ZipFile
