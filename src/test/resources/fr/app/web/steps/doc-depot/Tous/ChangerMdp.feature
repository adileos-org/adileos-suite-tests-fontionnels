@doc-depot2
@doc-depot
@tous
@change-mdp

Feature: [ DOC-DEPOT ] Changer de mot de passe

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire' 
		When ACCDOCDEP Cliquer sur le bouton 'Modification mot de passe'
		Then MODIF_MDP_DOC_DEP La page de modification du mot de passe 'DOC-DEPOT' s'affiche
		
Scenario Outline: Mot de passe incorrect
    Given MODIF_MDP_DOC_DEP Sur la page de modification du mot de passe 'DOC-DEPOT'
    
    When MODIF_MDP_DOC_DEP Saisir '<mdp1>' dans le champs 'Nouveau'
    And MODIF_MDP_DOC_DEP Saisir '<mdp2>' dans le champs 'Confirmation'
    And MODIF_MDP_DOC_DEP Cliquer le bouton 'Modifier'
    
    Then MODIF_MDP_DOC_DEP Le message d'erreur '<msg>' s'affiche
    When MODIF_MDP_DOC_DEP Revenir à la page d'accueil
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire' 
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche

Examples:
    | mdp1			|	mdp2			|	msg				|
    |						|						| Erreur : Le mot de passe est trop court (au moins 8 caractères). |
    |	abcdefgh	| 					|	Erreur : Les 2 mots de passe ne sont pas identiques. |		
    |	          | abcdefgh	|	Erreur : Les 2 mots de passe ne sont pas identiques. |					
    |	abcdefg 	|	abcdefg 	|	Erreur : Le mot de passe est trop court (au moins 8 caractères). |																
		|	abcdefgh	|	abcdefgh 	|	Erreur : Le mot de passe n'est pas assez complexe (utiliser des Majuscules, Chiffres, caractéres spéciaux) |
		|	abcdefgh2	|	abcdefgh2	|	Erreur : Le mot de passe n'est pas assez complexe (utiliser des Majuscules, Chiffres, caractéres spéciaux) |	
		
Scenario: Changer le mot de passe avec succès
    Given MODIF_MDP_DOC_DEP Sur la page de modification du mot de passe 'DOC-DEPOT'
    
    #Changer le mot de passe
    And MODIF_MDP_DOC_DEP Saisir 'abcDefgh2' dans le champs 'Nouveau'
    And MODIF_MDP_DOC_DEP Saisir 'abcDefgh2' dans le champs 'Confirmation'
    And MODIF_MDP_DOC_DEP Cliquer le bouton 'Modifier'
    Then MODIF_MDP_DOC_DEP Le message 'Modification du mot de passe réalisée.' s'affiche
    
    #Se déconnecter
    When MODIF_MDP_DOC_DEP Revenir à la page d'accueil
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire' 
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    
    #Accès au portail d'authentification et connexion avec le nouveau mot de passe
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    When AUTH01 Dans le champ 'Identifiant' saisir 'Form_B1'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'abcDefgh2'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    
    #Rétablir l'ancien mot de passe
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire' 
		When ACCDOCDEP Cliquer sur le bouton 'Modification mot de passe'
		Then MODIF_MDP_DOC_DEP La page de modification du mot de passe 'DOC-DEPOT' s'affiche
		And MODIF_MDP_DOC_DEP Saisir 'Form_1234' dans le champs 'Nouveau'
    And MODIF_MDP_DOC_DEP Saisir 'Form_1234' dans le champs 'Confirmation'
    And MODIF_MDP_DOC_DEP Cliquer le bouton 'Modifier'
    Then MODIF_MDP_DOC_DEP Le message 'Modification du mot de passe réalisée.' s'affiche
    
    When MODIF_MDP_DOC_DEP Revenir à la page d'accueil
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'BENEFICIAIRE - Beneficiaire' 
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    