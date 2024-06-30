# Diese Datei wird nur für einen neuen Gitpod-Workspace wirksam

# Base-Image
FROM gitpod/workspace-full

# Nutzer, von dem die folgenden Befehle ausgeführt werden.
USER gitpod

# Abfrage verfügbaren Java-Versionen: sdkman list java
# Amazon-Java "Corretto"
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
               sdk install java 17.0.9-amzn  && \
               sdk default java 17.0.9-amzn "
			
# Wir können auch globale NPM-Pakete installieren, z.B. "http-server".
# Dieses Programm kann dazu genutzt werden, um die mit dem Skript
# maven_javadoc.sh generierten HTML-Dateien im Ordner
# target/site/apidocs/ bereitzustellen.
RUN npm install -g http-server
