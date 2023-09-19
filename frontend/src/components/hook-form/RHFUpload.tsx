import React from 'react';
// form
import { useFormContext, Controller } from 'react-hook-form';
// @mui
import { FormHelperText } from '@mui/material';
//
import { UploadBox, UploadProps } from '../upload';

// ----------------------------------------------------------------------

interface Props extends Omit<UploadProps, 'file'> {
  name: string;
  multiple?: boolean;
}

export function RHFUploadBox({ name, files, showFilesList, ...other }: Props) {
  const { control } = useFormContext();

  const FileList = React.useMemo(() => (
    <ul>
      {files?.map((f) => <li>{f instanceof File ? `${f.name} ${f.size}` : f}</li>)}
    </ul>


  ), [files]);

  return (
    <>
      <Controller
        name={name}
        control={control}
        render={({ field, fieldState: { error } }) => (
          <>
            <UploadBox files={field.value} error={!!error} {...other} />

            {!!error && (
              <FormHelperText error sx={{ px: 2, textAlign: 'center' }}>
                {error.message}
              </FormHelperText>
            )}
          </>
        )}
      />
      {showFilesList ? FileList : null}
    </>
  );
};

export default UploadBox;