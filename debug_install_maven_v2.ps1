$Url = "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
$ZipFile = "maven_debug.zip"
$Dest = "maven_install"

Write-Host "Starting debug install..."
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

if (Test-Path $ZipFile) { Remove-Item $ZipFile }
if (Test-Path $Dest) { Remove-Item -Recurse -Force $Dest }

Invoke-WebRequest -Uri $Url -OutFile $ZipFile -UseBasicParsing
$FileItem = Get-Item $ZipFile
Write-Host ("Download complete. Size: " + $FileItem.Length)

Expand-Archive -Path $ZipFile -DestinationPath $Dest -Force
Write-Host "Extraction complete."

$Items = Get-ChildItem -Recurse $Dest
foreach ($item in $items) {
    Write-Host $item.FullName
}
