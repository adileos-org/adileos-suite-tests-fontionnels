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
		
Scenario: Visualiser les acteurs sociaux
    Given ACCDOCDEPRESP Sur la page d'accueil 'DOC-DEPOT' avec le profil 'Responsable'
    Then ACCDOCDEPRESP Le profil 'Responsable' et son identifiant de connexion est présent dans le tableau des acteurs sociaux
    Then ACCDOCDEPRESP Les profils 'Acteur Social' et leur identifiant de connexion sont présents dans le tableau des acteurs sociaux
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    