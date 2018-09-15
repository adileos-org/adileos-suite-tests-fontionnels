@doc-depot10
@doc-depot
@beneficiaire
@change-coordonnees

Feature: [ DOC-DEPOT ] Changer les coordonnées du bénéficiaire

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
		
Scenario: Changer les coordonnées
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    Then ACCDOCDEP_TEL Vérifie la valeur de 'Tel' qui doit contenir '0651256164'
    When ACCDOCDEP_TEL Change 'Tel' par '065125616'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Format de téléphone incorrect'
    Then ACCDOCDEP_TEL Vérifie la valeur de 'Tel' qui doit contenir '0651256164'
    
    Then ACCDOCDEP_MAIL_BENEF Vérifie la valeur de 'Mail' qui doit contenir 'pp_Form_B1@fixeo.com'
    When ACCDOCDEP_MAIL_BENEF Change 'Mail' par 'pp_Form_B1fixeo.com'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Format de mail incorrect ou absent'
    Then ACCDOCDEP_MAIL_BENEF Vérifie la valeur de 'Mail' qui doit contenir 'pp_Form_B1@fixeo.com'
    
    #Change les coordonnées avec succès
    When ACCDOCDEP_TEL Change 'Tel' par '0651256165'
    When ACCDOCDEP_MAIL_BENEF Change 'Mail' par 'pp_Form_B1@gmail.com'
    Then ACCDOCDEP_TEL Vérifie la valeur de 'Tel' qui doit contenir '0651256165'
    Then ACCDOCDEP_MAIL_BENEF Vérifie la valeur de 'Mail' qui doit contenir 'pp_Form_B1@gmail.com'
    
    #Rétabli les anciennes coordoonnées
    When ACCDOCDEP_TEL Change 'Tel' par '0651256164'
    When ACCDOCDEP_MAIL_BENEF Change 'Mail' par 'pp_Form_B1@fixeo.com'
    Then ACCDOCDEP_TEL Vérifie la valeur de 'Tel' qui doit contenir '0651256164'
    Then ACCDOCDEP_MAIL_BENEF Vérifie la valeur de 'Mail' qui doit contenir 'pp_Form_B1@fixeo.com'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    