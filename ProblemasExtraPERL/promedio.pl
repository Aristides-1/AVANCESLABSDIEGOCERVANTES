use strict;
use warnings;

sub calcular_promedio {
    my @notas = @_;  #Recibir las notas como una lista
    
    #Encontramos la nota mínima y máxima
    my $min = min(@notas);
    my $max = max(@notas);
    
    #Eliminar la primera aparición de la nota mínima
    @notas = grep { $_ != $min } @notas;
    
    #Duplicamos  la nota máxima
    push(@notas, $max);
    
    #Calculamos el promedio
    my $suma = 0;
    $suma += $_ for @notas;
    
  
