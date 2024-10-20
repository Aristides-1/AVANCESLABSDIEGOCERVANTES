use strict;
use warnings;

#Petición de ingreso de usuario
print "Ingrese su nombre de usuario:\n";

#Ingreso de usuario
my $user=<STDIN>;
chomp($user);
#Petición de ingreso de dominio 
print "Ingrese el dominio de su correo:\n";

#Ingreso de dominio
my $dominio=<STDIN>;
chomp($dominio);

#Impresión de correo electrónico
print "Su correo electrónico es:";
print "$user\@$dominio";

