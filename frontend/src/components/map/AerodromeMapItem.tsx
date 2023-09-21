import React from 'react';
// map
import { Circle, Tooltip } from 'react-leaflet';

// components
import { AerodromeInfo } from 'src/components/modal-dialog';
// @types
import { IAerodrome } from 'src/@types/aerodrome';
//
import { Dms2DD } from 'src/utils/dms2dd';

// ----------------------------------------------------------------------

interface IAerodromeMapItemProps {
  radius: number;
  color: string;
  aerodrome: IAerodrome;
};

const AerodromeMapItem: React.FC<IAerodromeMapItemProps> = (props) => {
  const {
    radius,
    color,
    aerodrome,
  } = props;

  const [open, setOpen] = React.useState<boolean>(false);

  const handleClick = React.useMemo(
    () => ({
      click() {
        setOpen(true);
      },
    }),
    [],
  );

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <>
      <AerodromeInfo aerodrome={aerodrome} isOpen={open} onClose={handleClose} />

      <Circle
        center={{ lat: Dms2DD.getLatDd(aerodrome.dms) as number, lng: Dms2DD.getLngDd(aerodrome.dms) as number }}
        eventHandlers={handleClick}
        pathOptions={{ fillColor: color }}
        radius={radius}>
        <Tooltip>
          Nome: {aerodrome.name}
          <br />
          Cidade: {aerodrome.city}

          <br />
          Criado em: {aerodrome.createdAt}

          <br />
        </Tooltip>
      </Circle>
    </>
  );
};

export default AerodromeMapItem;