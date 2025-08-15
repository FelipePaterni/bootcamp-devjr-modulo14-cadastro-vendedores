import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gender',
  standalone: false,
})
export class GenderPipe implements PipeTransform {
  transform(value: number): string {
    switch (value) {
      case 0:
        return 'Masculino';
      case 1:
        return 'Feminino';
      default:
        return '';
    }
  }
}
