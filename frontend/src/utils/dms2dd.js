import { DMS2Decimal } from 'dms-to-decimal';

export class Dms2DD {
  static firstPattern = /\d{6}S|N\/\d{7}W|E/i;

  static secondPattern = /\d{6}.\d{2}S|N\/\d{7}.\d{2}W|E/i;

  static thirdPattern = /\d{6},\d{2}\)\(S|N\/\d{7},\d{2}W|E/i;

  static getDecimalPart(dms, part) {
    let dmsPart = part === 'lat' ? dms.split('/')[0] : dms.split('/')[1];
    if (dmsPart.substring(0, 1) === '0')
      dmsPart = dmsPart.substring(1, dmsPart.length);

    let degree;
    let minutes;
    let seconds;

    if (this.firstPattern.test(dms) || this.secondPattern.test(dms) || this.thirdPattern.test(dms)) {
      degree = Number(dmsPart.substring(0, 2));
      minutes = Number(dmsPart.substring(2, 4));
    } else {
      throw new Error(`Coordenada inválida ${dms}`);
    };


    if (this.secondPattern.test(dms) || this.thirdPattern.test(dms)) {
      seconds = Number(dmsPart.substring(4, 9).replace(',', '.'));
    } else {
      seconds = Number(dmsPart.substring(4, 6));
    };

    const direction = dmsPart.substring(dmsPart.length - 1, dmsPart.length);

    return { degree, minutes, seconds, direction };
  };

  static getLatDd(dms) {
    const latDecimalDms = this.getDecimalPart(dms, 'lat');
    return DMS2Decimal(
      latDecimalDms.degree,
      latDecimalDms.minutes,
      latDecimalDms.seconds,
      latDecimalDms.direction,
    );
  };

  static getLngDd(dms) {
    const lngDecimalDms = this.getDecimalPart(dms, 'lng');
    return DMS2Decimal(
      lngDecimalDms.degree,
      lngDecimalDms.minutes,
      lngDecimalDms.seconds,
      lngDecimalDms.direction,
    );
  };
};