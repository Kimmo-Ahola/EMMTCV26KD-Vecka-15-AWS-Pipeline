# Färdig pipeline med deploy och tester efter

<img width="1667" height="224" alt="image" src="https://github.com/user-attachments/assets/9ea8b131-d602-4cb0-aef2-f916b8c71c17" />

## Skapa först en Elastic Beanstalk-applikation

- Skapa en .jar-fil från ditt repo som du laddar upp.
<img width="781" height="447" alt="image" src="https://github.com/user-attachments/assets/0c3cb1c1-73f0-469d-b7fb-4fa4d5dd5f9e" />

## Lägg till SERVER_PORT 5000 i environment
- Detta krävs för att spring boot-appen ska köras live.

<img width="1041" height="444" alt="image" src="https://github.com/user-attachments/assets/4bb4799c-cfe5-4618-ae78-b4d4b6c670af" />

## Lägg till 2 nya steg i din pipeline: Deploy samt Smoke Test
- Deploy To Elastic Beanstalk är ett specifikt Deploy-steg, inte en CodeBuild!
<img width="876" height="846" alt="image" src="https://github.com/user-attachments/assets/cbbf9ce2-97dc-4d98-8bb4-84bc3c5d4ba1" />

OBS! Deploy måste ha en jar-fil från tidigare steg. Detta kräver att vi i Build skapar en artefact som skickar ut en .jar-fil.
Kom ihåg att välja BuildArtifact som källa för Deploy.

## IAM
- Om det inte fungerar beror det med största sannolikhet på IAM-rättigheter.
- Lägg därför till IAM för dina resurser på din Service Role för din CodePipeline. Välj Admin på ElasticBeanstalk (enklast)
<img width="561" height="334" alt="image" src="https://github.com/user-attachments/assets/e808d19f-9747-4532-a279-a48e4ec86c6c" />

och lägg till resurser i CodeBuild. CodeBuild måste komma åt SmokeTest
<img width="545" height="103" alt="image" src="https://github.com/user-attachments/assets/d448ffec-a248-447c-a569-aefc3276ee4a" />
