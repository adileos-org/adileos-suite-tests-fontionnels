@doc-depot8
@doc-depot
@acteur-social
@change-coordonnees

Feature: [ DOC-DEPOT ] Changer les coordonnées de l'acteur social

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_A1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'LEGRAIS - Marie' 
		
Scenario: Changer les coordonnées
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'LEGRAIS - Marie'
    
    Then ACCDOCDEP Vérifie la valeur de 'Tel pro' qui doit contenir '0606060606'
    When ACCDOCDEP Change 'Tel pro' par '060606060'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Format de téléphone incorrect'
    Then ACCDOCDEP Vérifie la valeur de 'Tel pro' qui doit contenir '0606060606'
    
    Then ACCDOCDEP Vérifie la valeur de 'Mail pro' qui doit contenir 'pp_Form_A1@fixeo.com'
    When ACCDOCDEP Change 'Mail pro' par 'pp_Form_A1gmail.com'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Format de mail incorrect ou absent'
    Then ACCDOCDEP Vérifie la valeur de 'Mail pro' qui doit contenir 'pp_Form_A1@fixeo.com'
    
    #Change les coordonnées avec succès
    When ACCDOCDEP Change 'Tel pro' par '0606060607'
    When ACCDOCDEP Change 'Mail pro' par 'pp_Form_A1@gmail.com'
    Then ACCDOCDEP Vérifie la valeur de 'Tel pro' qui doit contenir '0606060607'
    Then ACCDOCDEP Vérifie la valeur de 'Mail pro' qui doit contenir 'pp_Form_A1@gmail.com'
    
    #Rétabli les anciennes coordoonnées
    When ACCDOCDEP Change 'Tel pro' par '0606060606'
    When ACCDOCDEP Change 'Mail pro' par 'pp_Form_A1@fixeo.com'
    Then ACCDOCDEP Vérifie la valeur de 'Tel pro' qui doit contenir '0606060606'
    Then ACCDOCDEP Vérifie la valeur de 'Mail pro' qui doit contenir 'pp_Form_A1@fixeo.com'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    