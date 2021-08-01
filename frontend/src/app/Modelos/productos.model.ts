
export interface ProductosModelService{
  codigo: number;
  nombre: String;
  descripcion: String;
  precioU: number;
  stock: number;
  urlImg: String;
  idCat: number;
}
export interface ServerResponse{
  count: number;
  productos: ProductosModelService[];

}
