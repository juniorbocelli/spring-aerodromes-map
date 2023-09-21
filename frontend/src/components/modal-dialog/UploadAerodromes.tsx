import React from 'react';
import * as Yup from 'yup';
// @mui
import { Box, Button } from '@mui/material';
// form
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';
// components
import AlertDialog from 'src/components/modal-dialog/AlertDialog';
import FormProvider, { RHFUploadBox } from 'src/components/hook-form';
import { AerodromesTable } from 'src/components/aerodomes';
//
import Strings from 'src/shared/strings';
import { IAerodrome } from 'src/@types/aerodrome';

// ----------------------------------------------------------------------

type FormValuesProps = {
  file: string | File;
};

interface IUploadAerodromesProps {
  isOpen: boolean;
  onClose: () => void;
  onSubmitForm: (file: FormData) => Promise<IAerodrome[] | null>;
};

const UploadAerodromes: React.FC<IUploadAerodromesProps> = ({ isOpen, onClose, onSubmitForm }) => {
  // States
  const [aerodromes, setAerodromes] = React.useState<IAerodrome[] | null>(null);

  // Form
  const FormSchema = Yup.object().shape({
    file: Yup.mixed().required(Strings.ErrorMessages.forms.requiredMultiSelectObject('um', 'arquivo .json')).nullable(true),
  });

  const defaultValues = {
    file: '',
  };

  const methods = useForm<FormValuesProps>({
    resolver: yupResolver(FormSchema),
    defaultValues,
  });

  const {
    reset,
    handleSubmit,
    setValue,
  } = methods;

  const handleDropSingleFile = React.useCallback(
    (acceptedFiles: File[]) => {
      const file = acceptedFiles[0];

      const newFile = Object.assign(file, {
        preview: URL.createObjectURL(file),
      });

      if (newFile) {
        setValue('file', newFile, { shouldValidate: true });
      }
    },
    [setValue]
  );

  const onSubmit = async (data: FormValuesProps) => {
    const formData = new FormData();
    formData.append('file', data.file as File);

    const aerodromesOrNull = await onSubmitForm(formData);
    setAerodromes(aerodromesOrNull);

    // reset form
    reset();
  };

  const handdleClose = () => {
    onClose();
    setAerodromes(null);
  };

  // Effects
  React.useEffect(() => {
    reset();
  }, [reset, isOpen]);

  return (
    <AlertDialog
      open={isOpen}
      size={aerodromes === null ? "md" : "xl"}
      content={
        <>
          {
            aerodromes === null ? (
              <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
                <Box sx={{ display: 'flex', flexDirection: 'column', }}>
                  <RHFUploadBox
                    name="file"
                    accept={{ 'application/json': ['.json'] }}
                    showFilesList
                    sx={{ width: '100%', height: 300, mb: 2 }}
                    placeholder="Clique ou arraste seu arquivo aqui!"
                    onDrop={handleDropSingleFile}
                  />

                  <Button variant="contained" sx={{ flexGrow: 1 }} type="submit">
                    Enviar
                  </Button>
                </Box>
              </FormProvider>
            )
              :
              <AerodromesTable aerodromes={aerodromes} />
          }

        </>
      }
      onClose={handdleClose}
    />
  );
};

export default UploadAerodromes;