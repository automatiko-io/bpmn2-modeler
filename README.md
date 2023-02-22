# Create new version of Automatiko modeler

1. Make sure it is in sync with upstream
upstream	https://git.eclipse.org/r/bpmn2-modeler/org.eclipse.bpmn2-modeler.git

rebase on master branch.

2. Create new branch with version number 2.2.0

3. Update version of the modeller
./scripts/changeVersion.sh 1.5.4-SNAPSHOT 2.2.0

4. Build the most recent platform
mvn clean package -Pplatform-2022-12

5. Upload the updatesite to github releases.
