use strict;
use warnings;

sub calcular_promedio {
    my @notas = @_;  # Recibir las notas como una lista
    
    # Encontrar la nota mínima y máxima
    my $min = min(@notas);
    my $max = max(@notas);
    
    # Eliminar la primera aparición de la nota mínima
    @notas = grep { $_ != $min } @notas;
    
    # Duplicar la nota máxima (agregarla nuevamente al arreglo)
    push(@notas, $max);
    
    # Calcular el promedio
    my $suma = 0;
    $suma += $_ for @notas;
    
    my $promedio = $suma / @notas;
    return $promedio;
}

# Definición de las funciones max y min usando el enlace proporcionado
sub max {
    my ($maximo) = @_;
    foreach (@_) {
        $maximo = $_ if $_ > $maximo;
    }
    return $maximo;
}

sub min {
    my ($minimo) = @_;
    foreach (@_) {
        $minimo = $_ if $_ < $minimo;
    }
    return $minimo;
}

# Petición de ingreso de notas
my @notas;
my $input;

# Uso de una entrada continua de notas, agregando todas hasta que una sea -1
print "Ingrese las notas una por una (ingrese un valor negativo para terminar):\n";
while (1) {
    $input = <STDIN>;
    chomp($input);
    # Convertir la entrada en un número
    $input += 0;
    
    # Salir del ciclo si se ingresa un número negativo
    last if $input < 0;
    
    # Agregar la nota a la lista de notas
    push(@notas, $input);
}

# Calcular el promedio usando la función
my $promedio = calcular_promedio(@notas);

# Imprimir el resultado
print "El promedio ajustado es: $promedio\n";
