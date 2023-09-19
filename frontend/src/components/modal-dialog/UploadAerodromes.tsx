import React from 'react';
// components
import AlertDialog from './AlertDialog';
import { RHFUploadBox } from '../hook-form';
//
import { API_AERODROME_URL } from '../../routes/apis';

// ----------------------------------------------------------------------

interface IUploadAerodromesProps {
  isOpen: boolean;
  onClose: () => void;
};

const UploadAerodromes: React.FC<IUploadAerodromesProps> = ({ isOpen, onClose }) => (
  <AlertDialog
    open={isOpen}
    content={
      <RHFUploadBox
        name='file'
        mimeType='text/json'
      />
    }
    onClose={onClose}
  />
);

export default UploadAerodromes;