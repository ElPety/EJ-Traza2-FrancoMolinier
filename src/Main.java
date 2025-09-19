import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import Entidades.*;
import Repositorios.RepositorioEnMemoria;

public class Main {
    public static void main(String[] args) {
        // Iniciamos los repositorios
        RepositorioEnMemoria<Categoria> categoriaRepository = new RepositorioEnMemoria<>();
        RepositorioEnMemoria<ArticuloInsumo> articuloInsumoRepository = new RepositorioEnMemoria<>();
        RepositorioEnMemoria<ArticuloManufacturado> articuloManufacturadoRepository = new RepositorioEnMemoria<>();
        RepositorioEnMemoria<UnidadMedida> unidadMedidaRepository = new RepositorioEnMemoria<>();

        // Crear categorías pizza sandwiches bebidas insumos
        Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
        Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
        Categoria bebidas = Categoria.builder().denominacion("Bebidas").esInsumo(false).build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();
        //guardamos las categorias creadas en el repositorio
        categoriaRepository.save(pizzas);
        categoriaRepository.save(sandwiches);
        categoriaRepository.save(bebidas);
        categoriaRepository.save(insumos);

        // Crear unidades de medida
        UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos = UnidadMedida.builder().denominacion("Gramos").build();
        //guardamos las unidades de medida en el repositorio
        unidadMedidaRepository.save(kg);
        unidadMedidaRepository.save(litro);
        unidadMedidaRepository.save(gramos);

        // Crear el artículoinsumo sal
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .precioCompra(1.0)
                .stockActual(100)
                .stockMinimo(10)
                .stockMaximo(200)
                .esParaElaborar(true)
                .unidadMedida(gramos)
                .categoria(insumos)
                .build();

        // Crear el artículoinsumo harina
        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .precioCompra(0.5)
                .stockActual(50)
                .stockMinimo(5)
                .stockMaximo(100)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        // Crear el artículoinsumo aceite
        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .precioCompra(3.0)
                .stockActual(30)
                .stockMinimo(3)
                .stockMaximo(60)
                .esParaElaborar(true)
                .unidadMedida(litro)
                .categoria(insumos)
                .build();

        // Crear el artículoinsumo carne
        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .precioCompra(5.0)
                .stockActual(20)
                .stockMinimo(2)
                .stockMaximo(40)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        articuloInsumoRepository.save(sal);
        articuloInsumoRepository.save(harina);
        articuloInsumoRepository.save(aceite);
        articuloInsumoRepository.save(carne);

        // Crear imágenes para los artículos
        Imagen img1 = Imagen.builder().name("HawaianaPizza1").url("http://pizza.com/pizza1").build();
        Imagen img2 = Imagen.builder().name("HawaianaPizza2").url("http://pizza.com/pizza2").build();
        Imagen img3 = Imagen.builder().name("HawaianaPizza3").url("http://pizza.com/pizza3").build();
        Imagen img4 = Imagen.builder().name("LomoCompletoLomo1").url("http://lomo.com/lomo1").build();
        Imagen img5 = Imagen.builder().name("LomoCompletoLomo2").url("http://lomo.com/lomo2").build();
        Imagen img6 = Imagen.builder().name("LomoCompletoLomo3").url("http://lomo.com/lomo3").build();


        // Crear detalles de artículos manufacturados
        //Detalle de pizzahawaiana1
        ArticuloManufacturadoDetalle detalle1PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();
        //Detalle de pizzahawaiana2
        ArticuloManufacturadoDetalle detalle2PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(harina)
                .build();
        //Detalle de pizzahawaiana3
        ArticuloManufacturadoDetalle detalle3PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();
        //Detalle de lomocompleto1
        ArticuloManufacturadoDetalle detalle1LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();
        //Detalle de lomocompleto2
        ArticuloManufacturadoDetalle detalle2LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();
        //Detalle de lomocompleto3
        ArticuloManufacturadoDetalle detalle3LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(carne)
                .build();


        // Crear artículos manufacturados
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .descripcion("Pizza Hawaina")
                .precioVenta(12.0)
                .descripcion("Pizza con piña, jamón y azucar negra")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 20 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .descripcion("Lomo Completo")
                .precioVenta(15.0)
                .descripcion("Lomo completo con todos los ingredientes")
                .tiempoEstimadoMinutos(25)
                .preparacion("Cocinar a la parrilla por 25 minutos")
                .categoria(sandwiches)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1LomoCompleto, detalle2LomoCompleto, detalle3LomoCompleto)))
                .build();

        articuloManufacturadoRepository.save(pizzaHawaina);
        articuloManufacturadoRepository.save(lomoCompleto);


        // Mostrar todas las categorías
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tA continuacion todas las categorias disponibles:");
        List<Categoria> todasLasCategorias = categoriaRepository.findAll();
        todasLasCategorias.forEach(e -> System.out.println("\t\t  -->" + e ));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Mostrar todos los artículos insumos
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tA continuacion todos los artículos insumos disponibles:");
        List<ArticuloInsumo> todosLosArticulosInsumos = articuloInsumoRepository.findAll();
        todosLosArticulosInsumos.forEach(e -> System.out.println("\t\t  -->" + e ));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Mostrar todos los artículos manufacturados
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tA continuacion todos los artículos manufacturados disponibles:");
        List<ArticuloManufacturado> todosLosArticulosManufacturados = articuloManufacturadoRepository.findAll();
        todosLosArticulosManufacturados.forEach(e -> System.out.println("\t\t  -->" + e ));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Buscar un artículo manufacturado por ID
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        Optional<ArticuloManufacturado> articuloEncontrado = articuloManufacturadoRepository.findById(1L);
        articuloEncontrado.ifPresent(a -> System.out.println("\tArtículo manufacturado encontrado por ID 1: " + a));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Actualizar un artículo manufacturado por ID
        ArticuloManufacturado pizzaHawainaActualizada = ArticuloManufacturado.builder()

                .id(1L)
                .denominacion("Pizza Hawaina Actualizada")
                .precioVenta(14.0)
                .descripcion("Pizza con piña, jamón y queso extra")
                .tiempoEstimadoMinutos(22)
                .preparacion("Hornear por 22 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();
        //Mostrar articulo modificado por ID
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        articuloManufacturadoRepository.genericUpdate(1L, pizzaHawainaActualizada);
        Optional<ArticuloManufacturado> articuloVerificado = articuloManufacturadoRepository.findById(1L);
        articuloVerificado.ifPresent(a -> System.out.println("\tEl articulo manufacturado quedo de la siguiente manera: " + a));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Eliminar un artículo manufacturado por ID
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        articuloManufacturadoRepository.genericDelete(1L);
        Optional<ArticuloManufacturado> articuloEliminado = articuloManufacturadoRepository.findById(1L);
        if (articuloEliminado.isEmpty()) {
            System.out.println("\tEl artículo manufacturado con ID=1 ha sido eliminado correctamente");

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        // Mostrar todos los artículos manufacturados restantes
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\tTodos los artículos manufacturados restantes:");
        todosLosArticulosManufacturados = articuloManufacturadoRepository.findAll();
        todosLosArticulosManufacturados.forEach(e -> System.out.println("\t\t  -->" + e ));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        System.out.println("|--------------------------------------------|");
        System.out.println("|-------- Codigo Por Franco Molinier --------|");
        System.out.println("|--------------------------------------------|");
    }
}