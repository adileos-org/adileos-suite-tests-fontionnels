@doc-depot11
@doc-depot
@beneficiaire
@change-domic-postale

Feature: [ DOC-DEPOT ] Changer la domiciliation postale du bénéficiaire

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
		
Scenario: Changer la domiciliation postale
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    Then ACCDOCDEPBENEF Vérifie si l'adresse non éditable est '27 Bd Garibaldi 92130 issy les moulineaux'
    Then ACCDOCDEPBENEF Vérifie l'absence du champ de saisie pour l'adresse
    
    When ACCDOCDEPBENEF Sélectionner la domiciliation postale ''
    Then ACCDOCDEPBENEF Vérifie si aucune adresse n'est renseignée
    
    When ACCDOCDEPBENEF Saisir l'adresse 'Adresse fictive' pour la domiciliation postale
    Then ACCDOCDEPBENEF Vérifie si le champ de saisie est renseignée avec l'adresse 'Adresse fictive'
    
    When ACCDOCDEPBENEF Sélectionner la domiciliation postale '92-Les Hélices'
    Then ACCDOCDEPBENEF Vérifie si l'adresse non éditable est '27 Bd Garibaldi 92130 issy les moulineaux'
    Then ACCDOCDEPBENEF Vérifie l'absence du champ de saisie pour l'adresse
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    