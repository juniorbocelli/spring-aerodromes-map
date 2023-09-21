import React from 'react';
// form
import { useFormContext, Controller } from 'react-hook-form';
// @mui
import { FormHelperText } from '@mui/material';

// components
import { UploadBox, UploadProps } from '../upload';

// ----------------------------------------------------------------------

interface Props extends Omit<UploadProps, 'file'> {
  name: string;
  multiple?: boolean;
}

export function RHFUploadBox({ name, multiple, ...other }: Props) {
  const { control } = useFormContext();

  return (
    <Controller
      name={name}
      control={control}
      render={({ field, fieldState: { error } }) => (
        <>
          {
            multiple ? (
              <UploadBox
                multiple
                files={field.value}
                error={!!error}
                {...other}
              />
            )
              :
              (
                <UploadBox
                  file={field.value}
                  error={!!error}
                  {...other}
                />
              )
          }

          {!!error && (
            <FormHelperText error sx={{ px: 2, textAlign: 'center' }}>
              {error.message}
            </FormHelperText>
          )}
        </>
      )}
    />
  );
};

export default UploadBox;