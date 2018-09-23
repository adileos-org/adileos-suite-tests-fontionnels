@doc-depot17
@doc-depot
@acteur-social
@voir-doc-benef

Feature: [ DOC-DEPOT ] Visualiser un document du bénéficiaire en tant qu'acteur social

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_A1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'LEGRAIS - Marie' 
		
Scenario: Déposer un document en tant que bénéficiaire et le visualiser en tant qu'acteur social
    Given ACCDOCDEP Sur la page d'accueil 'DOC-DEPOT' avec le message 'LEGRAIS - Marie'
    
    When ACCDOCDEPACTSOC Cliquer sur le bouton 'Voir le détail' pour le bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    And ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_PREF_ESP Vérifier l'absence du document 'doc.pdf'

    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF_AJT_DOC Cliquer sur le bouton 'Ajouter un doc'
    And ACCDOCDEPBENEF Ajouter le document 'D:\DOC_TESTS\doc.pdf'
    And ACCDOCDEPBENEF Naviguer avec le lien 'Cliquez ici quand vous avez terminé.'
    And ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_PREF_ESP Vérifier la présence du document ajouté 'doc.pdf' 
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    When AUTH01 Dans le champ 'Identifiant' saisir 'Form_A1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'LEGRAIS - Marie' 
    
    When ACCDOCDEPACTSOC Cliquer sur le bouton 'Voir le détail' pour le bénéficiaire de nom 'BENEFICIAIRE' et de prénom 'Beneficiaire'
    And ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_PREF_ESP Vérifier la présence du document ajouté 'doc.pdf' 
    Then ACCDOCDEPACTSOC Vérifie l'absence du bouton 'Supprimer' pour le document 'doc.pdf'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire'
    
    When ACCDOCDEPBENEF_SECTION Cliquer sur le bouton 'Papier Administratif'
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_PREF_ESP Vérifier la présence du document ajouté 'doc.pdf' 
    When ACCDOCDEPBENEF_PREF_ESP Supprimer le document 'doc.pdf'
    And ACCDOCDEPBENEF Cliquer sur le bouton de confirmation pour la suppression du document
    And ACCDOCDEPBENEF Cliquer sur la catégorie de documents 'Autres'
    Then ACCDOCDEPBENEF_PREF_ESP Vérifier l'absence du document 'doc.pdf'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    