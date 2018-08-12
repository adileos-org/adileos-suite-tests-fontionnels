@suivi-benef1
@suivi-benef
@login

Feature: [ SUIVI BENEFICIAIRE | LOGIN ] Logins incorrects

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		When AUTH01 Accéder au Suivi des bénéficiaires
		Then AUTH01 La page 'Authentification SUIVI-BENEFICIAIRE' s'affiche
		
Scenario Outline: logins/mdp incorrects 
    Given AUTH01 Sur la page 'Authentification SUIVI-BENEFICIAIRE'
    When AUTH01 Dans le champ 'Identifiant' saisir '<uid>'
    And AUTH01 Dans le champ 'Mot de passe' saisir '<mdp>'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then AUTH01 Le message 'avez pas les droits pour accéder à ce module. Pour accéder à Doc-depot, cliquez ' s'affiche
    
Examples: 
      | uid             | mdp      |
      | robert.duval   | ZZZsso    |
      | ZZZZZ.duval    | ZZZsso    |
      | A012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789   |ZZZsso|
      | ZZZZZZZZZZZZZ  | A012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789 |
      
Scenario Outline: login non renseigné/mdp renseigné
    Given AUTH01 Sur la page 'Authentification SUIVI-BENEFICIAIRE'
    When AUTH01 Supprimer le contrôle front-end sur le champs 'Identifiant'
    When AUTH01 Dans le champ 'Identifiant' saisir '<uid>'
    And AUTH01 Dans le champ 'Mot de passe' saisir '<mdp>'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then AUTH01 Le message 'avez pas les droits pour accéder à ce module. Pour accéder à Doc-depot, cliquez ' s'affiche
    
Examples: 
      | uid             | mdp      |
      |                | ZZZsso		 |
      
Scenario Outline: logins renseigné/mdp non renseigné 
    Given AUTH01 Sur la page 'Authentification SUIVI-BENEFICIAIRE'
    When AUTH01 Supprimer le contrôle front-end sur le champs 'Mot de passe'
    When AUTH01 Dans le champ 'Identifiant' saisir '<uid>'
    And AUTH01 Dans le champ 'Mot de passe' saisir '<mdp>'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then AUTH01 Le message 'avez pas les droits pour accéder à ce module. Pour accéder à Doc-depot, cliquez ' s'affiche
    
Examples: 
      | uid            | mdp       |
      | robert.duval   |   				 |
      