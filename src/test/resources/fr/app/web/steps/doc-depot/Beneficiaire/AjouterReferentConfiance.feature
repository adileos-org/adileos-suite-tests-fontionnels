@doc-depot12
@doc-depot
@beneficiaire
@ajouter-ref-conf

Feature: [ DOC-DEPOT ] Ajouter/Supprimer un référent de confiance pour le bénéficiaire

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
		
Scenario: Ajouter et supprimer un référent de confiance d'une structure sociale
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_REF_CONF Cliquer sur le bouton 'Référents de confiance'
    And ACCDOCDEPBENEF Sélectionner la structure sociale 'Café 115'
    And ACCDOCDEPBENEF Sélectionner l'acteur social '- HELIN Pauline'
    And ACCDOCDEPBENEF Cliquer sur le bouton 'Ajouter' pour le référent de confiance
    Then ACCDOCDEPBENEF_PRES Vérifie la présence du référent de confiance de structure sociale 'Café 115', de nom 'HELIN', de prénom 'Pauline' et d'adresse '89 avenue de Verdun; 92130 Issy les Mx'
    
    When ACCDOCDEPBENEF Cliquer sur le bouton 'Supprimer' pour le référent de confiance de structure sociale 'Café 115', de nom 'HELIN' et de prénom 'Pauline'
    And ACCDOCDEPBENEF Cliquer le bouton de confirmation
    Then ACCDOCDEPBENEF_ABS Vérifie l'absence du référent de confiance de structure sociale 'Café 115', de nom 'HELIN', de prénom 'Pauline' et d'adresse '89 avenue de Verdun; 92130 Issy les Mx'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
Scenario: Ajouter et supprimer un référent de confiance avec saisie libre
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_REF_CONF Cliquer sur le bouton 'Référents de confiance'
    And ACCDOCDEPBENEF Sélectionner la structure sociale ''
    And ACCDOCDEPBENEF Saisir le nom 'DUPONT' du référent de confiance
    And ACCDOCDEPBENEF Saisir le prénom 'Jean' du référent de confiance    
    And ACCDOCDEPBENEF Cliquer sur le bouton 'Ajouter' pour le référent de confiance
    Then ACCDOCDEPBENEF_PRES02 Vérifie la présence du référent de confiance de structure sociale '', de nom 'DUPONT' et de prénom 'Jean'
    
    When ACCDOCDEPBENEF Cliquer sur le bouton 'Supprimer' pour le référent de confiance de structure sociale '', de nom 'DUPONT' et de prénom 'Jean'
    And ACCDOCDEPBENEF Cliquer le bouton de confirmation
    Then ACCDOCDEPBENEF_ABS02 Vérifie l'absence du référent de confiance de structure sociale '', de nom 'DUPONT' et de prénom 'Jean'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    