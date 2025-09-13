import { Component, OnInit } from '@angular/core';
import { Seller } from '../../interfaces/Seller';
import { SellersService } from '../../service/sellers.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-sellers',
  standalone: false,
  templateUrl: './sellers.component.html',
  styleUrl: './sellers.component.css',
})
export class SellersComponent implements OnInit {
  deleteSeller: Seller = {} as Seller;
  seller: Seller = {} as Seller;
  sellers: Seller[] = [];

  showForm: boolean = false;
  isEditing: boolean = false;

  constructor(
    private sellersService: SellersService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.loadSellers();
    if (!localStorage.getItem('alertShown')) {
      alert(
        '⚠️ Atenção!\n\n' +
          'Este projeto é apenas para fins de estudo.\n' +
          'Os dados cadastrados são fictícios e o sistema é resetado diariamente.\n\n' +
          'Obrigado por visitar!'
      );

      localStorage.setItem('alertShown', 'true');
    }
  }

  loadSellers() {
    this.sellersService.getSellers().subscribe({
      next: (data) => {
        this.sellers = data;
      },
    });
  }

  delayAlert() {
    alert(
      'ℹ️ Aviso:\n\n' +
        'Como este sistema é aberto ao público, as alterações podem levar alguns instantes para aparecer.'
    );
  }

  create() {
    this.showForm = true;
    this.isEditing = false;
  }

  edit(seller: Seller) {
    this.seller = seller;
    this.showForm = true;
    this.isEditing = true;
  }

  save(save: boolean) {
    if (save) {
      if (this.isEditing) {
        this.sellersService.update(this.seller).subscribe();
        this.delayAlert();
      } else {
        this.sellersService.save(this.seller).subscribe({
          next: (data) => {
            this.sellers.push(data);
            this.delayAlert();
          },
        });
      }
    }
    this.showForm = false;
    this.seller = {} as Seller;
  }

  delete(modal: any, seller: Seller) {
    this.deleteSeller = seller;
    this.modalService.open(modal).result.then((confirm) => {
      if (confirm) {
        this.sellersService.delete(seller).subscribe({
          next: () => {
            this.sellers = this.sellers.filter((s) => s !== seller);
            this.delayAlert();
          },
        });
      }
    });
  }
}
