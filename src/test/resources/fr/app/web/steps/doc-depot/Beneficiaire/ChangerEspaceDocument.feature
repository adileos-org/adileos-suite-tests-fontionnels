@doc-depot14
@doc-depot
@beneficiaire
@deposer-doc

Feature: [ DOC-DEPOT ] Changer le document d'espace en tant que bénéficiaire

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
		
Scenario: Changer le document d'espace
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF_AJT_DOC Cliquer sur le bouton 'Ajouter un doc'
    And ACCDOCDEPBENEF Ajouter le document 'D:\DOC_TESTS\doc.jpg'
    And ACCDOCDEPBENEF Naviguer avec le lien 'Cliquez ici quand vous avez terminé.'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Espace personnel'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier l'absence du document 'doc.jpg'
    When ACCDOCDEPBENEF Naviguer avec le lien 'Retour à la page d'accueil.'    
    
    And ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier la présence du document ajouté 'doc.jpg'
    When ACCDOCDEPBENEF_ESP Changer le document 'doc.jpg' d'espace
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier l'absence du document 'doc.jpg'
    When ACCDOCDEPBENEF Naviguer avec le lien 'Retour à la page d'accueil.'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Espace personnel'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier la présence du document ajouté 'doc.jpg'
    When ACCDOCDEPBENEF_ESP Changer le document 'doc.jpg' d'espace
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier l'absence du document 'doc.jpg'
    When ACCDOCDEPBENEF Naviguer avec le lien 'Retour à la page d'accueil.'
    
    And ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier la présence du document ajouté 'doc.jpg'
    When ACCDOCDEPBENEF_ESP Supprimer le document 'doc.jpg'
    And ACCDOCDEPBENEF Cliquer sur le bouton de confirmation pour la suppression du document
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_ESP Vérifier l'absence du document 'doc.jpg'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    