# Proxi2-Groupe6
Comment lancer l'application Java ProxiBanqueV2

Pré-requis:
	- Machine cible dotée d'un systeme d'exploitation Windows.
		
	- Installer un serveur d'application Tomcat 9 sur la machine cible et s'assurer qu'il est lancé.

		    (Téléchargé depuis : http://tomcat.apache.org/download-90.cgi)
			
	- Installer un serveur de base de donnée mySQL sur la machine cible et s'assurée qu'elle est lancée.
		
			(Par exemple WAMPserver permet d'en installer un, il est téléchargeable depuis http://www.wampserver.com/)
			
	- Créer une base de donnée nommée : "proxibanquefij", définir son encodage "utf8_general_ci".
		
			(En utilisant par exemple phpMyAdmin fournit dans WAMPserver)
Execution :
	- Créer les tables de la base de donnée en exécutant le fichier "SQL\creerTables.sql"
		
			(dans phpMyAdmin en cliquant sur l'onglet import)
			
	- Peupler la base de donnée avec des données en exécutant le fichier "SQL\peuplerTables.sql"
		
			(dans phpMyAdmin en cliquant sur l'onglet import)
			
			Important: bien décocher "Activer la vérification des clés étrangères" pour éviter les problèmes lors du peuplement
			
	- Copier le fichier "ProxiV2-AF-IJ.war" dans le repertoire "webapps" de Tomcat
		
			(ex: C:\apache-tomcat-9.0.0.M19\webapps, si Tomcat est installé dans C:\apache-tomcat-9.0.0.M19)
			
	- Accéder à l'application par un navigateur via l'url suivante "http://localhost:8085/ProxiV2-AF-IJ/"
		
			(le port 8085 dépend de votre configuration Tomcat)

Consulter la documentation: 
	- Double-cliquer sur le fichier index.html se trouvant dans le repertoire "doc" livré avec le fichier jar.
