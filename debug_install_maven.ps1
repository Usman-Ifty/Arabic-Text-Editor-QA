$Url = "https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
$ZipFile = "maven_debug.zip"
$Dest = "maven_install"

Write-Host "Starting debug install..."
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

if (Test-Path $ZipFile) { Remove-Item $ZipFile }
if (Test-Path $Dest) { Remove-Item -Recurse -Force $Dest }

Write-Host "Downloading to $ZipFile..."
try {
    Invoke-WebRequest -Uri $Url -OutFile $ZipFile -UseBasicParsing
    Write-Host "Download complete. File size: $((Get-Item $ZipFile).Length)"
}
catch {
    Write-Error "Download failed: $_"
    exit 1
}

Write-Host "Extracting..."
try {
    Expand-Archive -Path $ZipFile -DestinationPath $Dest -Force
    Write-Host "Extraction complete."
}
catch {
    Write-Error "Extraction failed: $_"
    exit 1
}

Write-Host "Contents of $Dest:"
Get-ChildItem -Recurse $Dest | Select-Object FullName
