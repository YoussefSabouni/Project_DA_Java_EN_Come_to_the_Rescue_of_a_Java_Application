#Open Classroom - Projet 2
**Prise de notes :**

- Corriger le fichier AnalyticsCounter
	1. ~~faire fonctionner le code existant.~~
	2. ~~traitement des exceptions.~~
	3. ~~pas de fermeture des ressources.~~
	4. variables qui se chevauchent.
	5. evolution du code impossible.
		~~- rajout des symptômes en fonction du fichier d'entrée.~~
		
- décomposer le code d'Alex en nouvelle classes ou méthodes.

- ~~corriger les commentaires bâclés ou inutiles.~~

- utiliser Javadoc pour chaque fonction. (Voir ISymptomReader et ReadSymptomeDataFromFile)

- Faire un diaporama.
	
    - Comment avez-vous localisé les problèmes ?
    - Quelles solutions vous avez employées ?
    - Quelle contraintes/différentes vous avez rencontrées ?
    - Comment vous les avez résolues ?
    - Ce que vous auriez modifié ou fait différemment ?


=================================================================================

- Etude des mails de Caroline

    -  Décomposition des besoins pour la première phase d'Analytics.

- Etude de l'échange entre Alex et Caroline
   	
    1. Analise des problèmes rencontrés par Alex.
	    - ~~Les symptômes sont comptabilisés en console mais ne sont pas correctement comptabilisés dans le fichier results.out.~~
	    - ~~L'ordre des symptômes n'est pas alphabétique dans le fichier results.out.~~
	    
	2. ~~Lire les données depuis un fichier texte qui fournira un symptôme
	par ligne.~~

	3. ~~Compter toutes les occurrences de tous les symptomes listé dans le
	fichier texte.~~

	4. ~~Générer un nouveau fichier texte nommé results.out qui liste chaque
	symptôme par ordre alphabétique suivi du nombre d'occurrences.~~  
        *Par exemple :*
        ```
        - Headache = 3
        - Rash = 0
        - Dilatec pupils = 2
        ```
	
	5. Map-Reduce ?

- ~~Lecture du code afin d'en comprendre la philosophie.~~ 

- ~~Etude du document Symtomps.txt.~~ 

- ~~Correction du code existants pour le rendre fonctionnel.~~

- Réorganisation du code
    - Nettoyage de la class Main.
    - Mise en place du code metier dans des classes métiers.

- Réalisation des fonctionnalités non-effectuer par Alex.

- Optimisation du code.
 