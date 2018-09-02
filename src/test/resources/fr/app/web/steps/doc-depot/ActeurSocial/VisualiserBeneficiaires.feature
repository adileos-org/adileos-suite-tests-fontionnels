@doc-depot9
@doc-depot
@acteur-social
@voir-beneficiares

Feature: [ DOC-DEPOT ] Visualiser les bénéficiares en tant qu'acteur social

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_A1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'LEGRAIS - Marie' 
		
Scenario: Visualiser les bénéficiares / Rechercher bénéficiares par nom, prénom, téléphone, mail, date de naissance, pays d'origine et adresse
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'LEGRAIS - Marie'
    
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'AAAAAAAAAAAA' et de prénom 'Aaaaaaaaaaaa'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '4'
    
    #Vérifier filtre nom - minuscules
    When ACCDOCDEP Saisir le filtre de recherche 'dupont'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre nom - majuscules
    When ACCDOCDEP Saisir le filtre de recherche 'Dupont'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre prénom - minuscules
    When ACCDOCDEP Saisir le filtre de recherche 'jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '2'
    
    #Vérifier filtre prénom - majuscules
    When ACCDOCDEP Saisir le filtre de recherche 'JEAN'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '2'
    
    #Vérifier filtre numéro de téléphone
    When ACCDOCDEP Saisir le filtre de recherche '0651256164'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre mail
    When ACCDOCDEP Saisir le filtre de recherche 'pp_Form_B3@fixeo.com'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier filtre mail partiel
    When ACCDOCDEP Saisir le filtre de recherche 'pp_Form_B'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre date de naissance
    When ACCDOCDEP Saisir le filtre de recherche '26/07/1963'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'AAAAAAAAAAAA' et de prénom 'Aaaaaaaaaaaa'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre pays d'origine - minuscules
    When ACCDOCDEP Saisir le filtre de recherche 'fran'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre pays d'origine - majuscules
    When ACCDOCDEP Saisir le filtre de recherche 'Fran'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '3'
    
    #Vérifier filtre adresse
    When ACCDOCDEP Saisir le filtre de recherche '27 bd Gallieni, 92130 ISSY-LES-MOULINEAUX'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '1'
    
    #Vérifier suppression du filtre
    When ACCDOCDEP Cliquer sur le bouton 'Supprimer filtre' pour la suppression du filtre
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'DUPONT' et de prénom 'Jean'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'JEAN' et de prénom 'Durand'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    Then ACCDOCDEPACTSOC Vérifie la présence du bénéficiaire de nom 'AAAAAAAAAAAA' et de prénom 'Aaaaaaaaaaaa'
    Then ACCDOCDEP Vérifie que le nombre de lignes filtrées est de '4'    
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    