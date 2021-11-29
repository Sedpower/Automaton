# AUTOMATA

### Compiler

Pour compiler le code, il suffit d’exécuter la commande `javac -cp ./class/ -d ./class/ ./src/*.java ./src/*/*.java` depuis le répertoire source du projet `Automaton/`

_Normalement le code est déjà compilé dans le dossier `class/`_

### Lancer l'application
Pour lancer l'application, exécuter la commande `java MyAppli` dans le répertoire `class/`

### Information utiles
Le dossier `doc` contient la Javadoc de l'application

Les fichiers contenants les automates se situent dans le répertoire `data/`, un fichier automate suit un formalisme précis:
* La première ligne contient l’ensemble des noms d'états séparés par un espace
* La deuxième ligne contient l'ensemble des éléments de l'alphabet de l'automate séparés par un espace (si il faut ajouter l’élément espace, écrire `space`)
* Les lignes suivantes contiennent les transitions (une par ligne) suivant la forme `<etatDepart> <caractere> <etatFin>`
* L'état initial doit se nommer **I** et les états finaux doivent se nommer **F** suivi d'un chiffre (<u>ex:</u> F0)

[Retrouver le code sur github](https://github.com/Sedpower/Automaton)

-------

### Compile

To compile the code, you need to execute `javac -cp ./class/ -d ./class/ ./src/*.java ./src/*/*.java` command from root folder `Automaton/`

_Normally the code is already compiled in the `class /` folder_

### Launch app
To launch the app, execute `java MyAppli` command in `class/` folder

### Usefull informations
`doc/` folder contain generated app Javadoc

The files containing automatas are located in the `data/` directory, an automa file follows a precise formalism:
* First line contains all states names separated by a single space
* Second line contains all alphabet elements separated by a single space (if you need to put space element, put `space`, it will be converted by space character)
* Others lines contains transitions (on per line), following this form `<startingSate> <character> <endingState>`
* Inital state must be named **I** and final states must be named **F** followed by number (<u>ex:</u> F0)

[Find this code on github](https://github.com/Sedpower/Automaton)
