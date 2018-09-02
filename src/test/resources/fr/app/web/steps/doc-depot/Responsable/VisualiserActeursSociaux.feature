@doc-depot5
@doc-depot
@responsable
@voir-acteurs-sociaux

Feature: [ DOC-DEPOT ] Visualiser les acteurs sociaux en tant que responsable

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_R'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'NGUYEN - Richard' 
		
Scenario: Visualiser les acteurs sociaux / Rechercher acteurs sociaux par nom, prénom, téléphone et mail
    Given ACCDOCDEPRESP Sur la page d'accueil 'DOC-DEPOT' avec le profil 'Responsable'
    Then ACCDOCDEPRESP Le profil 'Responsable' et son identifiant de connexion est présent dans le tableau des acteurs sociaux
    Then ACCDOCDEPRESP Les profils 'Acteur Social' et leur identifiant de connexion sont présents dans le tableau des acteurs sociaux
    
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'SECURITE', d'identifiant 'Form_A2' et de prénom 'Securite'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre nom - minuscules
    When ACCDOCDEP Saisir le filtre de recherche 'nguyen'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
		Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre nom - majuscules
    When ACCDOCDEP Saisir le filtre de recherche 'NGUYEN'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
		Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
		
		#Vérifier filtre prénom - minuscules
		When ACCDOCDEP Saisir le filtre de recherche 'marie'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre prénom - majuscules
    When ACCDOCDEP Saisir le filtre de recherche 'Marie'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre numéro de téléphone - entrées multiples
    When ACCDOCDEP Saisir le filtre de recherche '0651256164'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
		Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'SECURITE', d'identifiant 'Form_A2' et de prénom 'Securite'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '2'
    
    #Vérifier filtre numéro de téléphone - entrée unique
    When ACCDOCDEP Saisir le filtre de recherche '0606060606'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre mail partiel
    When ACCDOCDEP Saisir le filtre de recherche 'pp_Form'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'SECURITE', d'identifiant 'Form_A2' et de prénom 'Securite'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre mail
    When ACCDOCDEP Saisir le filtre de recherche 'pp_Form_A2@fixeo.com'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'SECURITE', d'identifiant 'Form_A2' et de prénom 'Securite'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier suppression du filtre
    When ACCDOCDEP Cliquer sur le bouton 'Supprimer' pour la suppression du filtre
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'NGUYEN', d'identifiant 'Form_R' et de prénom 'Richard'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'LEGRAIS', d'identifiant 'Form_A1' et de prénom 'Marie'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'SECURITE', d'identifiant 'Form_A2' et de prénom 'Securite'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    