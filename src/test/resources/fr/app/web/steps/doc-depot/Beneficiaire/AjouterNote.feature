@doc-depot15
@doc-depot
@beneficiaire
@deposer-doc

Feature: [ DOC-DEPOT ] Ajouter une note en tant que bénéficiaire

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
		
Scenario: Ajouter une note
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Notes et SMS'
    Then ACCDOCDEPBENEF Vérifier l'absence de la note 'Note de test'
    When ACCDOCDEPBENEF Saisir la note 'Note de test'
    And ACCDOCDEPBENEF_AJT_NOTE Cliquer sur le bouton 'Ajouter'
    Then ACCDOCDEPBENEF Vérifier la présence de la note 'Note de test'
    
    When ACCDOCDEPBENEF Supprimer la note 'Note de test'
    Then ACCDOCDEPBENEF Vérifier l'absence de la note 'Note de test'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    