#Open Classroom - Projet 2

## *Récapitulatif des besoins de Heme Biotech:*  

 ### Identifier les problèmes du programme:  
 #### Problème évoquées:  
1. faire fonctionner le code existant.
2. pas de traitement des exceptions.
3. pas de fermeture des ressources.
4. variable qui se chevauchent.
5. l'approche du code ne fonctionnera pas sur le long terme,  
il n'est pas assez dynamique concernant les symptômes.
6. Pas de JavaDoc sur dans la classe AnalyticsCounter.
7. Commentaires superflus/inutiles sur certains lignes d'instruction ou le code parle de lui meme.
8. Le code de la classe AnalyticsCounter ne respecte pas les principes de la POO.

 #### Solutions apportées:
1. Le programme se compile et s'execute, cependant il y a des fautes de conceptions, 
ce qui apporte pas la solution attendue. (Fautes dans les filtres des symptomes.)
2.
3.
4.
5.
6.
7.
8.
 
 ### Informations à apporter pour la réunion :
 
 - **Questions posées par Heme Biotech ?**  
    - comment vous avez localisé les problèmes ?  
    - quelles solutions vous avez employées ?  
    - quelles contraintes ou difficultés vous avez rencontrées ?  
    - comment vous les avez résolues ?  
    - Qu'est-ce que vous auriez modifié ou fait différemment ?

    
 

 

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
    - quelles contraintes ou difficultés vous avez rencontrées ?
    - Comment vous les avez résolues ?
    - Ce que vous auriez modifié ou fait différemment ?
    La sortie du fichier est écrasé à chaque execution du programme, j'aurai mis une date et heure au nom du fichier
     pour eviter celui. Aussi peut etre mettre le chemin de sortie et d'entrée des fichiers.


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
 