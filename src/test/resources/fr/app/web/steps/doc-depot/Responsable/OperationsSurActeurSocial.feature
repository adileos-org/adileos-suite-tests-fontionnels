@doc-depot6
@doc-depot
@responsable
@oper-acteurs-sociaux

Feature: [ DOC-DEPOT ] Opérations sur un acteur social en tant que responsable

Background:
		Given Sur la page 'Authentification' URL 'ENV:URL_HOME'
		Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
		When AUTH01 Dans le champ 'Identifiant' saisir 'Form_R'
    And AUTH01 Dans le champ 'Mot de passe' saisir 'Form_1234'
    And AUTH01 Cliquer sur le bouton 'SE CONNECTER'
    Then ACCDOCDEP La page d'accueil 'DOC-DEPOT' s'affiche avec le message 'NGUYEN - Richard' 
		
Scenario: Ajouter, modifier et supprimer un acteur social 
    Given ACCDOCDEPRESP Sur la page d'accueil 'DOC-DEPOT' avec le profil 'Responsable'
    
    When ACCDOCDEPRESP_SECT Cliquer sur le bouton ' + Acteur social  '
    When ACCDOCDEPRESP Renseigner le nom ''
    When ACCDOCDEPRESP Renseigner le prénom ''
    When ACCDOCDEPRESP Renseigner le téléphone ''
    When ACCDOCDEPRESP Renseigner le mail ''
    When ACCDOCDEPRESP_AJT Cliquer sur le bouton 'Ajouter'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Attention, tous les champs ne sont pas renseignés'
    
    When ACCDOCDEPRESP Renseigner le nom 'Duval'
    When ACCDOCDEPRESP Renseigner le prénom 'Robert'
    When ACCDOCDEPRESP Renseigner le téléphone '0651256166'
    When ACCDOCDEPRESP Renseigner le mail 'pp_Form_A2fixeo.com'
    When ACCDOCDEPRESP_AJT Cliquer sur le bouton 'Ajouter'
    Then ACCDOCDEP Vérifie la présence du message d'erreur 'Erreur : Format de mail incorrect ou absent pp_Form_A2fixeo.com.'
    
    #Création de l'acteur social avec succès
    When ACCDOCDEPRESP Renseigner le nom 'Duval'
    When ACCDOCDEPRESP Renseigner le prénom 'Robert'
    When ACCDOCDEPRESP Renseigner le téléphone '0651256166'
    When ACCDOCDEPRESP Renseigner le mail 'pp_Form_A2@fixeo.com'  
    When ACCDOCDEPRESP_AJT Cliquer sur le bouton 'Ajouter'
    Then ACCDOCDEP Vérifie la présence du message de succès 'Compte créé avec succès'
    
    #Modification de l'acteur social
    When ACCDOCDEPRESP_SECT Cliquer sur le bouton ' + Acteur social  '
    When ACCDOCDEPRESP Cliquer sur l'icône 'Modifier' de l'acteur social de nom 'DUVAL' et de prénom 'Robert'
		When ACCDOCDEPRESP Renseigner le téléphone '0651256165'
		When ACCDOCDEPRESP_MOD Cliquer sur le bouton 'Modifier'
    Then ACCDOCDEPRESP Vérifie la présence de l'acteur social de nom 'DUVAL', de prénom 'Robert', de téléphone '0651256165' et de mail 'pp_Form_A2@fixeo.com'

		#Suppression de l'acteur social    
    When ACCDOCDEPRESP Cliquer sur l'icône 'Supprimer' de l'acteur social de nom 'DUVAL' et de prénom 'Robert'
    When ACCDOCDEPRESP Confirmer la suppression de l'acteur social
    Then ACCDOCDEPRESP Vérifie l'absence de l'acteur social de nom 'DUVAL', de prénom 'Robert', de téléphone '0651256165' et de mail 'pp_Form_A2@fixeo.com'
    
    When ACCDOCDEP Cliquer sur le bouton 'Déconnexion'
    Then AUTH01 La page 'Authentification DOC-DEPOT' s'affiche
    Then AUTH01 Le message de déconnexion 'Vous êtes déconnecté!' s'affiche
    
    
    
    